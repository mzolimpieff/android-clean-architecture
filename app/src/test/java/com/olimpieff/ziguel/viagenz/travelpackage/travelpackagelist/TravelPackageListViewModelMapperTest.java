package com.olimpieff.ziguel.viagenz.travelpackage.travelpackagelist;

import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Matheus on 10/07/17.
 */
public class TravelPackageListViewModelMapperTest {
    @Test
    public void fromEntity() throws Exception {
        ArrayList<TravelPackageEntity> entities = new ArrayList<>();

        TravelPackageEntity entity = new TravelPackageEntity();
        entity.description = "description";
        entity.name = "name";
        entity.value = 20.0;
        entity.locationImageUrl = "url";

        entities.add(entity);

        ArrayList<TravelPackageListViewModel> viewModels = TravelPackageListViewModelMapper.fromEntity(entities);
        TravelPackageListViewModel viewModel = viewModels.get(0);

        assertEquals(viewModel.imageUrl, entity.locationImageUrl);
        assertEquals(viewModel.title, entity.name);
        assertEquals(viewModel.value, "R$20,00");
    }

}