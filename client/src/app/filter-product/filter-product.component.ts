import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-filter-product',
  templateUrl: './filter-product.component.html',
  styleUrls: ['./filter-product.component.css']
})
export class FilterProductComponent implements OnInit {
  product:Product=new Product();
  products:Product[]=new Array;
  constructor(private productService:ProductService,private router:Router) { }

  ngOnInit(): void {
   // this.getProducts();
   
  }
  onSubmit(){
   console.log(this.product);
   this.setFilterURL();
   this.goToFilterProductList();
   //console.log(this.productService.constructURL(this.product));
  }
  goToFilterProductList() {
    this.router.navigate(['/display-filtered-products']);
  }
    //console.log(this.products[0]);
  //    return this.products;
  setFilterURL()
  {this.productService.constructURL(this.product);}
  OnClick()
  {window.alert("Thanks for purchasing this");} 
}
