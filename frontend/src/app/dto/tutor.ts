export interface Tutor {
  id: string;
  name: string;
  image: string;
  phoneNumber: string;
  description: string;
  location: string;
  sessionPreferences: SessionPreferences;
}

export interface SessionPreferences {
  price: number;
  duration: SessionDurationEnum;
  subjects: string[];
  studentLevels: string[];
  places: string[];
}

export enum SessionDurationEnum {
  ONE_HOUR = '1 ora',
  ONE_HOUR_AND_HALF = '1 ora si jumatate',
  TWO_HOURS = '2 ore',
  MORE_THAN_TWO_HOURS = 'Mai mult de 2 ore'
}

export enum SessionPlaceEnum {
  ONLINE = 'Online',
  TUTOR_PLACE = 'La domiciliul tutorelui',
  STUDENT_PLACE = 'La domiciliul studentului',
  TUTORING_CENTRE = 'La centrul de meditatii'
}
