import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

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

  getDataById(apiUrl : string) {
    return this.http.get<any>(apiUrl + 'id?=' +);
  }
}
