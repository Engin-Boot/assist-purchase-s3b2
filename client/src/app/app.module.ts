import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//import {HttpClientModule  } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product-list/product-list.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { DeleteProductComponent } from './delete-product/delete-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ClientComponent } from './client/client.component';
import { AdminComponent } from './admin/admin.component';
import {  FormsModule} from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { PurchaseHomeComponent } from './purchase-home/purchase-home.component';
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CreateProductComponent,
    DeleteProductComponent,
    UpdateProductComponent,
    ClientComponent,
    AdminComponent,
    PurchaseHomeComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
