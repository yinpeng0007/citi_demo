import {Component, OnInit} from '@angular/core';
import {CardService} from '../../service/card.service';
import {Card} from '../../model/model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  selectedCard;
  cardList = [];
  increaseTo;

  constructor(private cardService: CardService,
              private router: Router) {
  }

  ngOnInit() {
    this.getCards();
  }

  getCards(): void {
    this.cardService.getCards().subscribe(result => {
      this.cardList = result;
      if (result.length > 0) {
        this.selectedCard = this.cardList[0];
        this.increaseTo = this.selectedCard.currentLimit;
      }
    });
  }

  cardChange(): void {
    this.increaseTo = this.selectedCard.currentLimit;
  }

  submit() {
    if (!this.increaseTo) {
      alert('please fill in limit!');
      return;
    }

    if (isNaN(this.increaseTo)) {
      alert('limit must be Numernic!');
      return;
    }

    if (this.increaseTo > this.selectedCard.maxLimit) {
      alert('limit can not greater than max limit!');
      return;
    }

    const params = {
      id: this.selectedCard.id,
      currentLimit: this.increaseTo
    };

    this.cardService.updateCard(params).subscribe(res => {
      this.router.navigate([`submitResult`], {
        queryParams: {
          id: this.selectedCard.id
        }
      });
    });
  }

}
