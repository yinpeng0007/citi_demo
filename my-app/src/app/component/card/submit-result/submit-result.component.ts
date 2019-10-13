import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { Location } from '@angular/common';
import {Card} from '../../../model/model';
import {CardService} from '../../../service/card.service';


@Component({
  selector: 'app-submit-result',
  templateUrl: './submit-result.component.html',
  styleUrls: [ './submit-result.component.css' ]
})
export class SubmitResultComponent implements OnInit {
  currentCard: Card;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private cardService: CardService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const id = params.id
      this.cardService.getCardById(id).subscribe(card => {
        this.currentCard = card;
      });
    });
  }


  goBack(): void {
    this.router.navigate([`card`]);
  }

}
