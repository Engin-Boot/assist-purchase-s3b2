import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-filter-product',
  templateUrl: './filter-product.component.html',
  styleUrls: ['./filter-product.component.css']
})
export class FilterProductComponent implements OnInit {
  product:Product=new Product();
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
  }
  onSubmit(){
   //console.log(this.product);
     this.productService.constructURL(this.product);
  }
}
