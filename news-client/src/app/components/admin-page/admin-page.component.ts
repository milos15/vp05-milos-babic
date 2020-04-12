import { NewsService } from './../../services/news.service';
import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/model/news';
import { AdService } from 'src/app/services/ad.service';
import { Ad } from 'src/app/model/id';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  private ads: Ad[] = [];
  page = 0;
  filter = '';
  constructor(private adService: AdService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    // this.adService.getAll(this.page).subscribe(data => { this.ads = data; });
    this.adService.getAllByPageAndFilter(this.page, this.filter).subscribe((res: Ad[]) => {this.ads = res});
  }


  save(ad:Ad) {
    this.adService.saveAd(ad).subscribe(data => this.loadData());
  }

  editAd(ad: Ad) {
    this.adService.editAd(ad).subscribe(data => this.loadData());
  }

  deleteAd(id:number) {
    this.adService.deleteAd(id).subscribe(data => this.loadData());
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
