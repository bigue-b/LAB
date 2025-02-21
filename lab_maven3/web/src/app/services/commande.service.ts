import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  private apiUrl = 'http://localhost:8080/commandes'; // URL du backend

  constructor(private http: HttpClient) {}

  getCommande(): Observable<string> {
    return this.http.get(this.apiUrl, { responseType: 'text' });
  }

  getSomme(a: number, b: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/somme?a=${a}&b=${b}`);
  }
}
