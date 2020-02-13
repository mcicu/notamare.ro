export class Tutor {
  name: string;
  image: string;
  subjects: string[];
  price: number;
  description: string;


  constructor(name: string, image: string, subjects: string[], price: number, description: string) {
    this.name = name;
    this.image = image;
    this.subjects = subjects;
    this.price = price;
    this.description = description;
  }
}
