import { Category } from './category';

export interface News {
    id?: number;
    name: string;
    descritpion: string;
    content: string; 
    category: Category; 
}