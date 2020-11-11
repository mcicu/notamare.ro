import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'staticResourceQualifier'
})
export class StaticResourceQualifierPipe implements PipeTransform {
  transform(value: string, ...args: any[]): any {
    console.log("pipe called");
    return '/backend/static/' + value + '?' + Date.now();
  }
}
