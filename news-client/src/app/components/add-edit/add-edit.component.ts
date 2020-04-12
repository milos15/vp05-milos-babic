
import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Ad } from 'src/app/model/id';

@Component({
  selector: 'app-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.css']
})
export class AddEditComponent implements OnInit {

  @Input()
  ad: Ad;

  @Output()
  saveAd: EventEmitter<Ad> = new EventEmitter<Ad>(); 


  constructor() { }

  ngOnInit() {
  }

  save() {
    this.saveAd.emit(this.ad);
    this.ad = {
      name: '',
      description: '',
      content: '', 
      price: 0, 
      location: ''
    }
  }
}
