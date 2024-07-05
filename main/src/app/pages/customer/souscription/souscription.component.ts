import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../../services/api.service";
import {BusinessActivity, Country, Purpose, TypeEntity} from "../../../modeles/base-entity";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {DatePipe} from "@angular/common";
import {Customer} from "../../../modeles/customer";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-souscription',
  templateUrl: './souscription.component.html',
  styleUrl: './souscription.component.scss'
})
export class SouscriptionComponent implements OnInit {
  showAlert: boolean = false;
  purposes: Purpose[] =[];
  typeEntities: TypeEntity[] =[];
  businesses: BusinessActivity[] =[];
  countries: Country[] =[];
  form: FormGroup;
  private customer: Customer = {};
  constructor(private service: ApiService, private formBuilder: FormBuilder, private datepipe: DatePipe, private toastr: ToastrService) {
    this.form = this.formBuilder.group({
      'companyName': ['', Validators.required],
      'purpose': ['', Validators.required],
      'typeEntity': ['', Validators.required],
      'businessActivity': ['', Validators.required],
      'systemBanking': [''],
      'country': ['', Validators.required],
      'registrationNumber': ['', Validators.required],
      'dateIncorporation': ['', Validators.required],
      'directorName': ['', Validators.required],
      'passportNumber': ['', Validators.required],
      'designatedName': ['', Validators.required],
      'email': ['', [Validators.required, emailValidator]]
    })
  }

  getPurposes() {
    this.service.getData('/mcb/entity/purpose').subscribe(data => {
      this.purposes = data;
    });
  }

  getTypeEntity() {
    this.service.getData('/mcb/entity/type_entity').subscribe(data => {
      this.typeEntities = data;
    });
  }

  getBusiness() {
    this.service.getData('/mcb/entity/business_activity').subscribe(data => {
      this.businesses = data;
    });
  }
  getCountry() {
    this.service.getData('/mcb/entity/country').subscribe(data => {
      this.countries = data;
    });
  }

  ngOnInit(): void {
    this.getPurposes();
    this.getTypeEntity();
    this.getBusiness();
    this.getCountry();
  }

  next() {

  }

  souscription() {
    this.customer = this.form.value;
    if (this.form.get('purpose')?.value) {
      const purpose = new Purpose();
      purpose.id = this.form.get('purpose')?.value;
      this.customer.purpose = purpose;
    }
    if (this.form.get('typeEntity')?.value) {
      const typeEntity = new TypeEntity();
      typeEntity.id = this.form.get('typeEntity')?.value;
      this.customer.typeEntity = typeEntity;
    }
    if (this.form.get('businessActivity')?.value) {
      const businessActivity = new BusinessActivity();
      businessActivity.id = this.form.get('businessActivity')?.value;
      this.customer.businessActivity = businessActivity;
    }
    if (this.form.get('country')?.value) {
      const country = new Country();
      country.id = this.form.get('country')?.value;
      this.customer.country = country;
    }
    if (this.form.get('dateIncorporation')?.value) {
      let date = new Date(this.form.get('dateIncorporation')?.value);
      this.customer.dateIncorporation = date;
    }

    this.service.postData('/mcb/customer/create', this.customer).subscribe(data => {
      this.toastr.success('Subscription successfully completed');
      this.form.reset();
    });
  }
}

export function emailValidator(control: FormControl): { [key: string]: any } | null {
  const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  const valid = emailRegex.test(control.value);
  return valid ? null : { 'invalidEmail': { value: control.value } };
}
