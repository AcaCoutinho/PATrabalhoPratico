function [Location] = get_location(case_library)

    Location = rand(2059, 1);
    cur_latlon = [];
    
    for j=1:size(case_library,1)

        if(case_library{j, 'CouncilArea'} == "Hobsons Bay City Council")
            council_latlon = [-37.8639, 144.8309];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Maribyrnong City Council ")
            council_latlon = [-37.8045, 144.9009];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end
        
        if(case_library{j, 'CouncilArea'} == "Brimbank City Council")
            council_latlon = [-37.7830, 144.8321];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Melton City Council")
            council_latlon = [-37.6820, 144.5870];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Wyndham City Council")
            council_latlon = [-37.8973, 144.6707];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Melbourne City Council")
            council_latlon = [-37.8138, 144.9672];
            cur_latlon(1) = case_library{j, 'Lattitude'};
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Moonee Valley City Council")
            council_latlon = [-37.7641, 144.9250];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Hume City Council")
            council_latlon = [-37.6832, 144.9176];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Moreland City Council")
            council_latlon = [-37.7410, 144.9692];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Darebin City Council")
            council_latlon = [-37.7402, 145.0035];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Yarra City Council")
            council_latlon = [-37.8186, 145.0007];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Whittlesea City Council")
            council_latlon = [-37.6451, 145.0676];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Banyule City Council")
            council_latlon = [-37.7654, 145.0453];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Boroondara City Council")
            council_latlon = [-37.8346, 145.0589];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Manningham City Council")
            council_latlon = [-37.7866, 145.1324];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Nillumbik Shire Council")
            council_latlon = [-37.6888, 145.1116];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Monash City Council")
            council_latlon = [-37.8822, 145.1642];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Whitehorse City Council")
            council_latlon = [-37.8177, 145.1805];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Maroondah City Council")
            council_latlon = [-37.8081, 145.2424];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Stonnington City Council")
            council_latlon = [-37.8563, 145.0297];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end


        if(case_library{j, 'CouncilArea'} == "Knox City Council")
            council_latlon = [-37.8715, 145.2448];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Glen Eira City Council")
            council_latlon = [-37.8639, 144.8309];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Kingston City Council")
            council_latlon = [-37.9661, 145.0576];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Greater Dandenong City Council")
            council_latlon = [-37.9847, 145.2173];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Casey City Council")
            council_latlon = [-38.0200, 145.2989];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Port Phillip City Council")
            council_latlon = [-37.8356, 144.9445];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Bayside City Council")
            council_latlon = [-37.9590, 145.01695];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Frankston City Council")
            council_latlon = [-38.1468, 145.1226];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end

        if(case_library{j, 'CouncilArea'} == "Macedon Ranges Shire Council")
            council_latlon = [-37.4849, 144.5854];
            cur_latlon(1) = (case_library{j, 'Lattitude'});
            cur_latlon(2) = (case_library{j, 'Longtitude'});
            Location(j,:) = calculate_location(cur_latlon, council_latlon);
        end
    end 
end

function [res] = calculate_location(cur_case_latlon, new_case_latlon)
    Ncur_case_latlon1 = (max([cur_case_latlon(1), new_case_latlon(1)])/min([cur_case_latlon(1), new_case_latlon(1)]));
    Nnew_case_latlon1 = 1;
    Ncur_case_latlon2 = 1;
    Nnew_case_latlon2 = (min([cur_case_latlon(2), new_case_latlon(2)])/max([cur_case_latlon(2), new_case_latlon(2)]));

    res = 1 - ((abs(Ncur_case_latlon1 - Nnew_case_latlon1) * 1 - abs(Ncur_case_latlon2 - Nnew_case_latlon2) * 1)/(1+1));
end