import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgZorroAntdModule, NZ_I18N, zh_CN } from 'ng-zorro-antd';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { registerLocaleData } from '@angular/common';
import zh from '@angular/common/locales/zh';
import {AppRoutingModule} from './app-routing.module';
import {CardComponent} from './component/card/card.component';
import {CardService} from './service/card.service';
import {SubmitResultComponent} from './component/card/submit-result/submit-result.component';

registerLocaleData(zh);

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    SubmitResultComponent
  ],
  imports: [
    BrowserModule,
    NgZorroAntdModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [{ provide: NZ_I18N, useValue: zh_CN }, CardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
