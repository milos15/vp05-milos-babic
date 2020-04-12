import { News } from './news';

export class Comment implements CommentInterface{
    id? : number;
    username: string;
    text: string;
    newsId: number;
    comments: Comment;

    constructor(commentConf: CommentInterface) {
        this.id = commentConf.id;
        this.username = commentConf.username;
        this.text = commentConf.text;
        this.newsId = commentConf.newsId;
        this.comments = commentConf.comments;
    }
}

export interface CommentInterface {
    id? : number;
    username? : string;
    text?: string;
    newsId?: number;
    comments? : Comment;
}