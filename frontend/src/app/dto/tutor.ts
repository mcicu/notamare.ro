export class Tutor {
  id: string;
  name: string;
  image: string;
  subjects: string[];
  session: { price: number, duration: number };
  description: string;
  stars: number;


  constructor(id: string, name: string, image: string, subjects: string[], session: { price: number; duration: number }, description: string, stars: number) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.subjects = subjects;
    this.session = session;
    this.description = description;
    this.stars = stars;
  }
}
