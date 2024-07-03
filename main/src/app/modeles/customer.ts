import {BusinessActivity, Country, Purpose, Status, TypeEntity} from "./base-entity";

export class Customer {
  customerId: number;
  companyName: string;
  purpose: Purpose;
  typeEntity: TypeEntity;
  businessActivity: BusinessActivity;
  systemBanking: string;
  country: Country;
  registrationNumber: string;
  dateIncorporation: Date;
  directorName: string;
  designatedName: string;
  email: string;
  status: Status;
}
