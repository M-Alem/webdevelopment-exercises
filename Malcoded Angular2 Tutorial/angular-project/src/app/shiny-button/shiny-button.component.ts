import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shiny-button',
  templateUrl: './shiny-button.component.html',
  styleUrls: ['./shiny-button.component.css']
})
export class ShinyButtonComponent implements OnInit {

  public color: string;

  constructor() { 
    this.color = this.generateRandomColor();
  }

  ngOnInit() {
  }

  generateRandomColor(){
    return '#' + (Math.random()*0xFFFFFF<<0).toString(16);
  }

}
