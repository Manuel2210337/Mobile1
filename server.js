require('dotenv').config();
const { ApolloServer } = require('apollo-server');
const db = require('./database/db'); // Usa el Knex que ya configuraste
const typeDefs = require('./graphql/typeDefs');
const resolvers = require('./graphql/resolvers/index'); // Importa el index.js correcto

async function startServer() {
  const server = new ApolloServer({
    typeDefs,
    resolvers,
    context: () => ({ db })
  });

  const { url } = await server.listen({ port: process.env.PORT || 4000 });
  console.log(`🚀 Servidor corriendo en ${url}`);
}

startServer().catch(err => {
  console.error('Error al iniciar el servidor:', err);
});
