import {SessionPreferences} from './tutor';

export interface TutorInput {
  name: string;
  image: string;
  phoneNumber: string;
  description: string;
  location: string;
  visible: boolean;
  sessionPreferences: SessionPreferences;
}
