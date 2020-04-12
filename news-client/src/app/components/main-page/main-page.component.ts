import { AdService } from './../../services/ad.service';
import { Component, OnInit } from '@angular/core';
import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Ad } from 'src/app/model/id';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  private ads: Ad[] = [];
  page = 0;

  filter= '';

  constructor(private adService: AdService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData() {

    //this.adService.getAll(this.page).subscribe(data => { this.ads = data; 
    //});
    this.adService.getAllByPageAndFilter(this.page, this.filter).subscribe((res: Ad[]) => {this.ads = res});
  }

  nextPage() {
    this.page += 1;
    this.loadData();
  }

  prevPage() {
    if (this.page >= 0) {
      this.page -= 1;
      this.loadData();
    }
  }

  search() {
    this.loadData();
    this.filter = '';
  }
}
