import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'enumToMap'
})
export class EnumToMapPipe implements PipeTransform {

  transform(value, args?: string[]): any {
    const result = [];
    const keys = Object.keys(value);
    const values = Object.values(value);
    for (let i = 0; i < keys.length; i++) {
      result.push({key: keys[i], value: values[i]});
    }
    return result;
  }
}
