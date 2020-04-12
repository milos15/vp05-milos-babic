import { HttpClient } from '@angular/common/http';
import { Ad } from './../model/id';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdService {
 
  private path = 'api/ads';
  private pathForFilter = 'api/ads-filter'; 
  
  private pageSize = 5; 

  constructor(private http: HttpClient) { }

  getAll(page: number): Observable<Ad[]> { 
    return this.http.get<Ad[]>(this.path +`/?page=${page}&size=${this.pageSize}`);
  }

  getAllByPageAndFilter(page:number, name: string): Observable<Ad[]> {
    return this.http.get<Ad[]>(this.pathForFilter +`/?page=${page}&size=${this.pageSize}&name=${name}`);
  }

  getAd(id: number): Observable<Ad> {
    return this.http.get<Ad>(this.path +`/${id}`);
  }

  saveAd(ad: Ad): Observable<Ad> {
    return this.http.post<Ad>(this.path, ad);
  }

  deleteAd(id: number): Observable<Ad> {
    return this.http.delete<Ad>(`api/ads/${id}`);
  }

  editAd(ad: Ad): Observable<Ad> {
    return this.http.put<Ad>(`api/ads/${ad.id}`, ad);
  }
}

