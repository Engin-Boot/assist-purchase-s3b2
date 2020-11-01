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
   //console.log(this.product);
   this.getProducts();
   //console.log(this.productService.constructURL(this.product));
  }
  goToProductList() {
    this.router.navigate(['/product-list']);
  }
  private getProducts():void
  {
    this.productService.getFilteredProductList(this.product).subscribe(data => {
      this.products=data;
    });
    //console.log(this.products);
  //    return this.products;
  }
}
