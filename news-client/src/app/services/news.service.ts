import { News } from './../model/news';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private path = 'api/news-page';
  private pageSize = 5;

  constructor(private http: HttpClient) { }

  getAll(page: number): Observable<News[]> { 
    // Meni jedino ispise podatke na pocetnoj stranici na nacin kako samo postavio dole ispod
    return this.http.get<News[]>(this.path +`/?page=${page}&size=${this.pageSize}`);
  }

  getByNameAndCategory(name: string, categoryId: number, page:number) : Observable<News[]> {
    return this.http.get<News[]>(`api/news?page=${page}&size=${this.pageSize}&name=${name}&category=${categoryId}`);
  }

  getNews(id: number): Observable<News> {
    return this.http.get<News>(`api/news/${id}`);
  }

  saveNews(news: News): Observable<News> {
    return this.http.post<News>('api/news-page', news);
  }

  deleteNews(id: number): Observable<News> {
    return this.http.delete<News>(`api/news/${id}`);
  }

  editNews(news: News): Observable<News> {
    return this.http.put<News>(`api/news/${news.id}`, news);
  }
}
