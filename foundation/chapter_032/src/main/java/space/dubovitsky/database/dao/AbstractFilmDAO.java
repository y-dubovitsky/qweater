package space.dubovitsky.database.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

//! Можно не объявлять как компонент!
public abstract class AbstractFilmDAO {

    @Autowired
    private DataSource dataSource; //! Эти нпастройки наследуют все потомки (dataSource - объявлен как Бин в .xml)

    public AbstractFilmDAO() {
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
