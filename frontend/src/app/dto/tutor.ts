export class Tutor {
  name: string;
  subjects: string[];
  price: number;
  description: string;


  constructor(name: string, subjects: string[], price: number, description: string) {
    this.name = name;
    this.subjects = subjects;
    this.price = price;
    this.description = description;
  }
}
