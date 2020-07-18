FROM node:14.5.0-alpine3.10
RUN mkdir -p /app
WORKDIR /app
COPY . /app
RUN npm install
EXPOSE 3001
CMD npm start