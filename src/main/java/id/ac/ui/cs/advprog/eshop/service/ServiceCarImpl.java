package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.RepoCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ServiceCarImpl implements ServiceCar {

    @Autowired
    private RepoCar repoCar;

    @Override
    public Car create(Car car) {
        repoCar.create(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        Iterator<Car> carIterator = repoCar.findAll();
        List<Car> allCar= new ArrayList<>();
        carIterator.forEachRemaining(allCar::add);
        return allCar;
    }

    @Override
    public Car findById(String carId) {
        Car car = repoCar.findById(carId);
        return car;
    }

    @Override
    public void update(String carId, Car car) {
        repoCar.update(carId, car);
    }

    @Override
    public void deleteCarById(String carId) {
        repoCar.delete(carId);
    }
}
