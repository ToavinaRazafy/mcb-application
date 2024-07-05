import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {DashboardView, Page} from "../modeles/dashboard-view";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(public http: HttpClient) {
  }

  searchByCriteria(apiUrl: string, criteria: any): Observable<any> {
    return this.http.post(apiUrl, criteria);
  }

  postData(apiUrl: string, data: any): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    const options = {headers: headers, responseType: 'text' as 'json'};
    return this.http.post<any>(apiUrl, data, options);
  }

  putData(apiUrl: string, data: any): Observable<any> {
    return this.http.put<any>(apiUrl, data);
  }

  getData(apiUrl: string) {
    return this.http.get<any>(apiUrl);
  }

  getDataById(apiUrl : string, id: number) {
    return this.http.get<any>(apiUrl + 'id?=' + id);
  }

  getView(search: any,page: number, size: number): Observable<Page<DashboardView>> {
    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString())
    return this.http.get<Page<DashboardView>>('/mcb/customer/list', {params});
  }
}
