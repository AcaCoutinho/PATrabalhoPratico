function [new_case] = reuse(retrieved_cases, new_case)

    x1 = retrieved_cases{:,9}; % Land Size
    x2 = retrieved_cases{:,11}; % Year Built
    y = retrieved_cases{:,5}; % Prices

    X = [ones(size(x1)) x1 x2];
    
    b = X\y;

    for k=1:size(retrieved_cases,1)
        if(retrieved_cases{k, 'Similarities'} == max(retrieved_cases.Similarities))
            best_case = retrieved_cases{k};
        end
    end

    if(new_case.councilArea == best_case.councilArea)
        new_case = best_case;
    end
end