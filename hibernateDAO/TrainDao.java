package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Train;

public class TrainDao 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public Train findTrain(int id)
	{
		Train findedTrain = EntityManager.find(Train.class,id);
		return findedTrain;	
	}
	public Train insertTrain(Train Train)
	{
		Train findedTrain = findTrain(Train.getTrainId());
		if(findedTrain == null)
		{
		transaction.begin();
		EntityManager.persist(Train);
		transaction.commit();
		}
		return null;
	}
	
	
	public Train deleteTrain(int id)
	{
		Train findedTrain = findTrain(id);
		if(findedTrain != null)
		{
			transaction.begin();
			EntityManager.remove(findedTrain);
			transaction.commit();
		}
		return findedTrain;
	}
	
	public Train updateTrain(Train Train,int id)
	{
		Train updateTrain = findTrain(id);
		if(updateTrain != null)
		{
			Train.setTrainId(id);
			transaction.begin();
			EntityManager.merge(Train);
			transaction.commit();
			return Train;
		}
		return updateTrain;
	}
}
