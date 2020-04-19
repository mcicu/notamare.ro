import {NgModule} from '@angular/core';
import {APOLLO_OPTIONS, ApolloModule} from 'apollo-angular';
import {HttpLink, HttpLinkModule} from 'apollo-angular-link-http';
import {InMemoryCache} from 'apollo-cache-inmemory';
import {ApolloLink} from 'apollo-link';
import {HttpHeaders} from '@angular/common/http';

const uri = '/backend/graphql'; // <-- add the URL of the GraphQL server here
export function createApollo(httpLink: HttpLink) {

  const link = httpLink.create({uri});

  const authMiddleware = new ApolloLink((operation, forward) => {
    let headers = new HttpHeaders();
    if (null !== localStorage.getItem('jwt')) {
      headers = headers.set('Authorization', 'Bearer ' + localStorage.getItem('jwt'));
    }

    operation.setContext({headers});
    return forward(operation);
  });

  return {
    link: ApolloLink.from([authMiddleware, link]),
    cache: new InMemoryCache({
      addTypename: false
    }),
  };
}

@NgModule({
  exports: [ApolloModule, HttpLinkModule],
  providers: [
    {
      provide: APOLLO_OPTIONS,
      useFactory: createApollo,
      deps: [HttpLink],
    },
  ],
})
export class GraphQLModule {
}
