import { ActivatedRoute } from '@angular/router';
import { AdService } from './../../services/ad.service';
import { Component, OnInit } from '@angular/core';
import { Ad } from 'src/app/model/id';

@Component({
  selector: 'app-ad-page',
  templateUrl: './ad-page.component.html',
  styleUrls: ['./ad-page.component.css']
})
export class AdPageComponent implements OnInit {

  ad: Ad;
  id: number;
  sub: any;
  
  constructor(private adService: AdService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAds();
  }
  
  getAds() {
    this.sub = this.route.params.subscribe(param => {
      this.id = +param.id;
      this.adService.getAd(this.id)
        .subscribe((res : Ad) => {
          this.ad = res;
        })
    })
  }

}
