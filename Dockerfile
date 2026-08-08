FROM postgres:16

COPY init.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_DB chronos_db
ENV POSTGRES_USER ${DB_USERNAME}
ENV POSTGRES_PASSWORD ${DB_PASSWORD}