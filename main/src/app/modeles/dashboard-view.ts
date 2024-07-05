export class DashboardView {
  customerId?: number;
  companyName?: string;
  typeEntity?: string;
  businessActivity?: string;
  country?: string;
  registrationNumber?: string;
  status?: string;
}
export interface Page<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}
