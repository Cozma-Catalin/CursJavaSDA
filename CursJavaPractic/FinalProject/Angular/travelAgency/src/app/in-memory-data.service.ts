import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Account } from './account/account';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

  createDb() {
    const accounts = [
      {id: 1 , name : ''}
    ];
    return {accounts};
   }


   genId(accounts: Account[]): number {
    return accounts.length > 0 ? Math.max(...accounts.map(Account => Account.id)) + 1 : 11;
  }
}
