import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../modeles/customer";
import {ApiService} from "../../../services/api.service";
import {FormBuilder} from "@angular/forms";
import {DatePipe} from "@angular/common";
import {ToastrService} from "ngx-toastr";
import {DashboardView, Page} from "../../../modeles/dashboard-view";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrl: './list.component.scss'
})
export class ListComponent implements OnInit {
  customers: DashboardView[] = [];
  totalElements: number = 0;
  pageSize: number = 50;
  currentPage: number = 0;
  private search: any = {};
  constructor(private service: ApiService, private formBuilder: FormBuilder, private toastr: ToastrService) {

  }
  ngOnInit(): void {
    this.getItems();
  }
  getItems(): void {
    this.service.getView(this.search,this.currentPage, this.pageSize).subscribe(
      (page: Page<DashboardView>) => {
        this.customers = page.content;
        this.totalElements = page.totalElements;
      }
    );
  }

  onPageChange(page: number): void {
    this.currentPage = page;
    this.getItems();
  }
}
