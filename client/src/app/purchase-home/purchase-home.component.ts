import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-purchase-home',
  templateUrl: './purchase-home.component.html',
  styleUrls: ['./purchase-home.component.css']
})
export class PurchaseHomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  Onclick()
  {this.router.navigate['product-list'];}
}
