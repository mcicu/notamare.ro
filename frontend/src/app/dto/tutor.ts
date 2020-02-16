export class Tutor {
  name: string;
  image: string;
  subjects: string[];
  session: { price: number, duration: number };
  description: string;
  stars: number;


  constructor(name: string, image: string, subjects: string[], session: { price: number; duration: number }, description: string, stars: number) {
    this.name = name;
    this.image = image;
    this.subjects = subjects;
    this.session = session;
    this.description = description;
    this.stars = stars;
  }
}
