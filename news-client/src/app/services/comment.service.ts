import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NewsService } from './news.service';
import { Observable } from 'rxjs';
import { Comment } from 'src/app/model/comment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private path = 'api/news'
  constructor(private http : HttpClient) { }

  getAllComments(newsId: number) : Observable<Comment[]>{
    return this.http.get<Comment[]>(`${this.path}/${newsId}/comments`);
  }

  postComment(newsId: number, comment: Comment): Observable<Comment> {
    let headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Comment>(`${this.path}/${newsId}`, comment, {headers});
  }

  postCommentForComment(newsId: number, commentId: number, comment: Comment) : Observable<Comment> {
    let headers : HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.put<Comment>(`api/news/${newsId}/comments/${commentId}`, comment, {headers});
  }
}
