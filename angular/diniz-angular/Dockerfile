# Use uma imagem oficial do Node.js como base
FROM node:16

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie todos os arquivos do projeto para o diretório de trabalho no container
COPY . .

# Instale as dependências do projeto
RUN npm install

# Construa o projeto
RUN npm run build

# Exponha a porta do servidor Angular
CMD ["npm", "start"]
