export class Tutor {
  id: string;
  name: string;
  image: string;
  subjects: string[];
  session: { price: number, duration: number };
  description: string;
  phoneNumber: string;
  county: string;
  stars: number;
  preferences: { studentLevels: string[], tutoringLocations: string[] };


  constructor(id: string, name: string, image: string, subjects: string[], session: { price: number; duration: number }, description: string, phoneNumber: string, county: string, stars: number, preferences: { studentLevels: string[]; tutoringLocations: string[] }) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.subjects = subjects;
    this.session = session;
    this.description = description;
    this.phoneNumber = phoneNumber;
    this.county = county;
    this.stars = stars;
    this.preferences = preferences;
  }
}
