export class StudiedCard {
    user_id: number;
    card_id: number;
    stars: number;
    finished_on: number;

   
  
   
     constructor(user_id: number, card_id: number, stars: number, finished_on: number) {
       this.user_id = user_id;
       this.card_id = card_id;
       this.stars = stars;
       this.finished_on = finished_on;
     }
   }