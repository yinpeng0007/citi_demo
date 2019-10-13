import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Observable} from 'rxjs';
import {Card} from '../model/model';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({providedIn: 'root'})
export class CardService {

  private getCardsUrl = 'api/card/list';

  private baseCardUrl = 'api/card/';

  constructor(
    private http: HttpClient) {
  }

  /** GET cards from the server */
  getCards(): Observable<Card[]> {
    return this.http.get<Card[]>(this.getCardsUrl);
  }

  /** GET cards from the server by id */
  getCardById(id: number): Observable<Card> {
    return this.http.get<Card>(`${this.baseCardUrl}/${id}`);
  }

  /** PUT card from the server by id */
  updateCard(card: any): Observable<Card> {
    const url = `${this.baseCardUrl}/${card.id}`;
    return this.http.put<Card>(url, card, httpOptions);
  }

}
