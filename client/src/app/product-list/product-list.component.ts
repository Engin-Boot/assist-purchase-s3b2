import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Displayproduct } from '../displayproduct';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products:Product[]=new Array;
  displays:Displayproduct[];
  constructor(private productService:ProductService,private router:Router) { }

  ngOnInit(): void {
   this.getProducts();
  }
  private getProducts():void
  {
    this.productService.getProductList().subscribe(data => {
      this.products = data});
  //    return this.products;
  }
  
  
}
