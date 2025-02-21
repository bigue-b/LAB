import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { CommandeService } from '../services/commande.service';

@Component({
  selector: 'app-commande',
  standalone: true,
  imports: [CommonModule, HttpClientModule], 
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {  
  commandeMessage: string = '';
  sommeResult: number | null = null;

  constructor(private commandeService: CommandeService) {}

  ngOnInit(): void {
    this.getCommande();
  }

  getCommande(): void {
    this.commandeService.getCommande().subscribe(data => {
      this.commandeMessage = data;
    });
  }

  calculateSomme(): void {
    this.commandeService.getSomme(5, 6).subscribe(result => {
      this.sommeResult = result;
    });
  }
}
