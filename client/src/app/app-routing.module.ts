import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ClientComponent } from './client/client.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { DeleteProductComponent } from './delete-product/delete-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { FilterProductComponent } from './filter-product/filter-product.component';

const routes: Routes = [{path:'admin',component:AdminComponent},{path:'filter-product',component:FilterProductComponent},{path:'client',component:ClientComponent},{path:'create-product',component:CreateProductComponent},{path:'delete-product',component:DeleteProductComponent},{path:'product-list',component:ProductListComponent},{path:'update-product/:id',component:UpdateProductComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
