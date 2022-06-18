function [retrieved_indexes, similarities, new_case] = retrieve(case_library, new_case, threshold)

    weighting_factors = [4 5 4 3 3 2 1 5 5];

    type_sim = get_type_similarities();

    new_case_latlon = [];

    max_values = get_max_values(case_library);

    retrieved_indexes = [];
    similarities = [];

    to_remove = [];
    if ~isfield(new_case, 'rooms')
        to_remove = [to_remove 1];
    end

    if ~isfield(new_case, 'type')
        to_remove = [to_remove 2];
    end

    if ~isfield(new_case, 'price')
        to_remove = [to_remove 3];
    end

    if ~isfield(new_case, 'bathroom')
        to_remove = [to_remove 4];
    end

    if ~isfield(new_case, 'car')
        to_remove = [to_remove 5];
    end

    if ~isfield(new_case, 'landSize')
        to_remove = [to_remove 6];
    end

    if ~isfield(new_case, 'buildingArea')
        to_remove = [to_remove 7];
    end

    if ~isfield(new_case, 'yearBuilt')
        to_remove = [to_remove 8];
    end

    if ~isfield(new_case, 'location')
        to_remove = [to_remove 9];
    end

    weighting_factors(to_remove) = [];

    for i=1:size(case_library,1)
        
        distances = zeros(1,9);
        
        distances(1,1) = calculate_linear_distance(case_library{i,'Rooms'} / max_values('Rooms'), ...
                                new_case.rooms / max_values('Rooms'));
                            
        distances(1,2) = calculate_local_distance(type_sim, ...
                                case_library{i,'Type'}, new_case.type);
        
        distances(1,3) = calculate_linear_distance(case_library{i,'Price'} / max_values('Price'), ...
                                new_case.price / max_values('Price'));
        

        distances(1,4) = calculate_linear_distance(case_library{i,'Bathroom'} / max_values('Bathroom'), ... 
                                new_case.bathroom / max_values('Bathroom'));
        
        distances(1,5) = calculate_linear_distance(case_library{i,'Car'} / max_values('Car'), ... 
                                new_case.car / max_values('Car'));
        
        distances(1,6) = calculate_euclidean_distance(case_library{i,'Landsize'} / max_values('Landsize'), ... 
                                new_case.landSize / max_values('Landsize'));
                            
        distances(1,7) = calculate_euclidean_distance(case_library{i,'BuildingArea'} / max_values('BuildingArea'), ... 
                                new_case.buildingArea / max_values('BuildingArea'));
        
        distances(1,8) = calculate_linear_distance(case_library{i, 'YearBuilt'} / max_values('YearBuilt'), ... 
             new_case.yearBuilt / max_values('YearBuilt'));

        distances(1,9) = calculate_linear_distance(new_case.location, case_library{i, 'Location'});
                          
        distances(to_remove) = [];
        final_similarity = 1 - ((distances * weighting_factors') / sum(weighting_factors));
        
        if final_similarity >= threshold
            retrieved_indexes = [retrieved_indexes i];
            similarities = [similarities final_similarity];
        end
        
        fprintf('Case %d out of %d has a similarity of %.2f%%...\n', i, size(case_library,1), final_similarity*100);
    end
end

function[type_sim] = get_type_similarities()
    type_sim.categories = categorical({'u' , 't', 'h'});

    type_sim.similarities = [
        %  u   t   h
          1.0 0.5 0.3 % u
          0.5 1.0 0.8 % t
          0.3 0.8 1.0 % h
    ];
end

function [res] = calculate_local_distance(sim, val1, val2)

    i1 = find(sim.categories == val1);
    i2 = find(sim.categories == val2);
    res = 1 - sim.similarities(i1, i2);
end

function [res] = calculate_location(cur_case_latlon, new_case_latlon)
    cur_case_latlon(0) = cur_case_latlon/max(cur_case_latlon(0), new_case_latlon(0));
    new_case_latlon(0) = max(cur_case_latlon(1), new_case_latlon(1))/max(cur_case_latlon(1), new_case_latlon(1));
    cur_case_latlon(1) = max(cur_case_latlon(0), new_case_latlon(0))/max(cur_case_latlon(0), new_case_latlon(0));
    new_case_latlon(1) = cur_case_latlon/max(cur_case_latlon(0), new_case_latlon(0));

    res = 1 - ((abs(cur_case_latlon(0) - new_case_latlon(0)) * 1 - abs(cur_case_latlon(1) - new_case_latlon(1) * 1))/(1+1));
end

function [res] = calculate_linear_distance(val1, val2)
    diff = abs(val1 - val2);
    res = sum(diff) / length(diff); 
end

function [res] = calculate_euclidean_distance(val1, val2)
    diff = val1 - val2;
    res = sqrt(diff * diff') / length(diff);
end

function [max_values] = get_max_values(case_library)

    key_set = {'Rooms', 'Price' ,'Distance', 'Bathroom', 'Car', 'Landsize', 'BuildingArea', 'YearBuilt'};
    value_set = {max(case_library{:,'Rooms'}), max(case_library{:,'Price'}), max(case_library{:,'Distance'}), max(case_library{:,'Bathroom'})...
        ,max(case_library{:,'Car'}), max(case_library{:,'Landsize'}), max(case_library{:,'BuildingArea'}), max(case_library{:,'YearBuilt'})};
    max_values = containers.Map(key_set, value_set);
end
