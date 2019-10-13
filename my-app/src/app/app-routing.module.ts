import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {CardComponent} from './component/card/card.component';
import {SubmitResultComponent} from './component/card/submit-result/submit-result.component';

const routes: Routes = [
  {path: '', redirectTo: '/card', pathMatch: 'full'},
  {path: 'card', component: CardComponent},
  {path: 'submitResult', component: SubmitResultComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
