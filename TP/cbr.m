function [] = cbr()

    similarity_threshold = 0.9;
    
    formatSpec = '%C%C%f%C%f%f%f%f%f%f%f%f%f%C';

    case_library = readtable('13Melbourne_Samples_SelectAtribs_SemBedroom2.csv', ...
        'Delimiter', ',', ...
        'Format', formatSpec);

    %Location = rand(2060, 1);
    case_library.Location = get_location(case_library);

    % New case data
    new_case.rooms = 2;
    new_case.type = 'u';
    new_case.price = 50000;
    new_case.bathroom = 2;
    new_case.car = 1;
    new_case.landSize = 1136;
    new_case.buildingArea = 213;
    new_case.yearBuilt = 1938;
    new_case.location = 0.8;

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    fprintf('\nStarting retrieve phase...\n\n');
    
    [retrieved_indexes, similarities, new_case] = retrieve(case_library, new_case, similarity_threshold);
    
    retrieved_cases = case_library(retrieved_indexes, :);
    
    retrieved_cases.Similarity = similarities';

    fprintf('\nRetrieve phase completed...\n\n');

    disp(retrieved_cases);

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    fprintf('\nStarting reuse phase...\n\n');

    if (isfield(new_case, 'councilArea'))
        new_case = reuse(retrieved_cases, new_case);
    else
        new_case.councilArea = 'none';
    end
    
    fprintf('\n\nReuse phase completed...\n');