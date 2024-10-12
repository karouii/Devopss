package tn.esprit.tpfoyer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cglib.core.Block;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BlocServiceImplMockTest {
    @Mock
    BlocRepository blocRepository;
    @InjectMocks
    BlocServiceImpl blocService;

    Bloc bloc = new Bloc(1, "info", 12, null, null);
    List<Bloc> blocList = new ArrayList<Bloc>() {
        {
            blocList.add(new Bloc(2, "physique", 12, null, null));
            blocList.add(new Bloc(3, "Bloc Z", 120, null, null));

        }
    };
    @Test
    public void testRetrieveBloc(){
        Mockito.when(blocRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(bloc));
        Bloc bloc1 = blocService.retrieveBloc(2L);
        Assertions.assertNotNull(bloc1);
    }
}